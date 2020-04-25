package com.business.Utilities;

import java.sql.*;
import java.util.*;
import java.util.Map;

public class DBUtils {
    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;

    public static void createConnection(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void destroy() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

    public static int getRowCount() {
        int amountOfRows = 0;
        try {
            resultSet.last();
            amountOfRows = resultSet.getRow();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return amountOfRows;
    }

    public static List<String> getColumnNames(String query) {
        List<String> columns = new ArrayList<>();
        try {
            executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int colimnCount = rsmd.getColumnCount();
            for (int i = 1; i <= colimnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return columns;
    }

    public static List<String> executeQueryAndGetColumnValue(String query, String coulmnName) {
        executeQuery(query);
        List<String> values = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                values.add(resultSet.getString(coulmnName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return values;
    }

    public static boolean verifyEmployeeExists(String firstName, String lastName) {
        boolean exists = false;
        String query = "SELECT COUNT(*) as count \n" +
                "FROM employees\n" +
                "WHERE first_name = '" + firstName + "' and  last_name='" + lastName + "';";
        executeQuery(query);
        try {
            resultSet.next();
            exists = resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }


    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;
        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }


    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;

    }

    public static Object getCellValue(String query) {
        return getQueryResultList(query).get(0).get(0);
    }


    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }


    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);
    }
}
