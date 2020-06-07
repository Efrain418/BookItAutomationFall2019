package com.bookit.database;

import com.bookit.utilities.DBUtility;

import java.net.PortUnreachableException;

public class UserDB {
    public boolean checkIfUserExistingDB(String email) {


        /**
         * If count equals to 1 - users exist
         * @param email of user to look up
         * @return true, if user exist
         */

            String query = "SELECT COUNT(*) AS \"count\" FROM users WHERE email = '" + email + "'";

              System.out.println("Qurey :: " + query);
            long countOfUser = (long) DBUtility.getCellValue(query);
            return countOfUser == 1;
        }

    }


