package repository.customer;

import model.customer.CustomerType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private static final String SELECT_CUSTOMER_TYPE = "SELECT * FROM customer_type";
    private static final String GET_CUSTOMER_TYPE_BY_ID = "SELECT * FROM customer_type where customer_type_id = ?";

    @Override
    public CustomerType findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        CustomerType customerTypes = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_CUSTOMER_TYPE_BY_ID);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String customer_type_name = resultSet.getString(2);
                    customerTypes = new CustomerType(id, customer_type_name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerTypes;
    }

    @Override
    public List<CustomerType> findAll() {
        Connection connection= DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<CustomerType>customerTypes=new ArrayList<>();
        if(connection!=null){
            try {
                preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_TYPE);
                resultSet=preparedStatement.executeQuery();
                CustomerType customerType=null;
                while (resultSet.next()){
                    int customer_type_id=resultSet.getInt(1);
                    String customer_type_name=resultSet.getString(2);
                    customerType=new CustomerType(customer_type_id,customer_type_name);
                    customerTypes.add(customerType);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerTypes;
    }
}
