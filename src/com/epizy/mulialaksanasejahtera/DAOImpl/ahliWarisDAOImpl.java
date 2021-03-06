package com.epizy.mulialaksanasejahtera.DAOImpl;

import com.epizy.mulialaksanasejahtera.DAO.ahliWarisDAO;
import com.epizy.mulialaksanasejahtera.DataBaseConncetion.dataBaseConncetionFactory;
import com.epizy.mulialaksanasejahtera.Model.ahliWaris;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ahliWarisDAOImpl implements ahliWarisDAO {
    private final Connection connection;
    public  ahliWarisDAOImpl(){
        connection = dataBaseConncetionFactory.getConnection();
    }
    @Override
    public void Save(ahliWaris ahliWaris) {
        PreparedStatement preparedStatement = null;
        try {
            String insert = "INSERT INTO `ahli_waris`(`no_reg`, `nama_alhi`, `hubungan`) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,ahliWaris.getNoRegistrasi());
            preparedStatement.setString(2,ahliWaris.getNama());
            preparedStatement.setString(3,ahliWaris.getHubungan());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            try {
                String update = "UPDATE `ahli_waris` SET `nama_alhi`=?,`hubungan`=? WHERE `no_reg`=?";
                preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(1,ahliWaris.getNama());
                preparedStatement.setString(2,ahliWaris.getHubungan());
                preparedStatement.setString(3,ahliWaris.getNoRegistrasi());
                preparedStatement.executeUpdate();
            }catch (SQLException ex) {
                e.printStackTrace();
                ex.printStackTrace();
            }
        }
        finally {
            if(connection != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void Delete(Object object) {
        PreparedStatement preparedStatement = null;
        try {
            String delete = "DELETE FROM `ahli_waris` WHERE `no_reg`=?";
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<ahliWaris> GetAll() {
        List<ahliWaris> ahliWarisList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String select = "SELECT * FROM `ahli_waris`";
            preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ahliWaris ahliWaris = new ahliWaris();
                ahliWaris.setNoRegistrasi(resultSet.getString(1));
                ahliWaris.setNama(resultSet.getString(2));
                ahliWaris.setHubungan(resultSet.getString(3));
                ahliWarisList.add(ahliWaris);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  ahliWarisList;
    }

    @Override
    public List<ahliWaris> GetDataByOject(Object object) {
        List<ahliWaris> ahliWarisList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            String selectWhere = "SELECT * FROM `ahli_waris` " +
                    "WHERE `no_reg` LIKE ? OR `nama_alhi` LIKE ? OR `hubungan` LIKE ?";
            preparedStatement = connection.prepareStatement(selectWhere);
            preparedStatement.setString(1, String.valueOf(object));
            preparedStatement.setString(2, String.valueOf(object));
            preparedStatement.setString(3, String.valueOf(object));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ahliWaris ahliWaris = new ahliWaris();
                ahliWaris.setNoRegistrasi(resultSet.getString(1));
                ahliWaris.setNama(resultSet.getString(2));
                ahliWaris.setHubungan(resultSet.getString(3));
                ahliWarisList.add(ahliWaris);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
                try {
                    assert preparedStatement != null;
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return  ahliWarisList;
    }
}