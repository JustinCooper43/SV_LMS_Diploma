package com.streltsov.SV_LMS_Diploma.factory;

import com.streltsov.SV_LMS_Diploma.utils.OptionsUtils;

import java.sql.SQLException;

public class RunOptions {

    public static void main(String[] args) throws SQLException {

        OptionsUtils optionsUtils = new OptionsUtils(args);
        DaoRealisationFactory myDao = optionsUtils.getDaoRealisation();
        Class checkClass = myDao.getHwTaskDao().getClass();
    }
}
