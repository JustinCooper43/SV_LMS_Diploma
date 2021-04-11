package com.streltsov.SV_LMS_Diploma.utils;


import com.streltsov.SV_LMS_Diploma.factory.DaoFactory;
import com.streltsov.SV_LMS_Diploma.factory.DaoRealisationFactory;
import com.streltsov.SV_LMS_Diploma.factory.JDBCFactory;
import com.streltsov.SV_LMS_Diploma.sandBox.webSite.banking.JavaDeveloper;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;

import java.sql.SQLException;

public class OptionsUtils {

    public static final String DB = "dbType";
    public static final String MEM = "InMemory";
    public static final String JDBC = "jdbc";
    public static final String INIT_DB = "initDB";
    static final InitialDataJDBC initialDataJDBC = new InitialDataJDBC();
    private DaoRealisationFactory daoRealisation = null;

    public OptionsUtils(String[] args) {

        org.apache.commons.cli.Options options = new org.apache.commons.cli.Options();
        options.addRequiredOption(DB, "dbType", true, "Choose between daoInMemory or daoJDBC");
        options.addOption(INIT_DB, "createDB", false, "Filling to DB initial's data");

        CommandLine cmd;
        try {
            cmd = new DefaultParser().parse(options, args);
            defineConfig(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void defineConfig(CommandLine cmd) throws Exception {

        String dbOptions = cmd.getOptionValue(DB);
        if (MEM.equalsIgnoreCase(dbOptions)) {
            daoRealisation = new DaoRealisationFactory(dbOptions);
        } else if (JDBC.equalsIgnoreCase(dbOptions)) {
            daoRealisation = new DaoRealisationFactory(dbOptions);
            if (cmd.hasOption(INIT_DB)) {
                initialDataJDBC.createInitialData();
            }
        } else {
            throw new Exception("Please, choose the way to save data");
        }
    }

    public DaoRealisationFactory getDaoRealisation() {
        return daoRealisation;
    }
}
