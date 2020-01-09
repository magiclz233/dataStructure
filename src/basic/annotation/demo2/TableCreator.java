package basic.annotation.demo2;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 罗璋||luozhang@cnpc.com.cn
 * Description TODO 基于反射的注释处理器 {java注解.database.TableCreator注解.database.Member}
 * @version 1.0
 * @ClassName TableCreator
 * @date 2020/1/8 12:45
 */
public class TableCreator {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println(
                    "arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println(
                        "No DBTable annotations in class " +
                                className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns =
                        field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue; // Not a db table column
                }
                if (anns[0] instanceof SqlInteger) {
                    SqlInteger sInt = (SqlInteger) anns[0];
                    // Use field name if name not specified
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" +
                            getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SqlString) {
                    SqlString sString = (SqlString) anns[0];
                    // Use field name if name not specified.
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" +
                            sString.value() + ")" +
                            getConstraints(sString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder(
                        "CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append(
                            "\n " + columnDef + ",");
                }
                // Remove trailing comma
                String tableCreate = createCommand.substring(
                        0, createCommand.length() - 1) + ");";
                System.out.println("Table Creation SQL for " +
                        className + " is:\n" + tableCreate);
            }
        }
    }

    public static String getConstraints(Constraints c) {
        String constraints = "";
        if (!c.allowNull()) {
            constraints += "NOT NULL";
        }
        if (c.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (c.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
