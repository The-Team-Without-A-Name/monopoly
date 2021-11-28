package Server;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.apache.commons.cli.*;

public enum CLI {

    INST;

    private Options options = new Options();
    private CommandLineParser commandLineParser = new DefaultParser();
    private HelpFormatter formatter = new HelpFormatter();

    private int portNumber = 7000;

    public int getPortNumber() {
        return portNumber;
    }

    public void init() {
        options.addOption("p", "port", true, "The port the server is listening on.");
        options.addOption("h", "help", false, "Help menu to display formatter print help page.");

        formatter.setWidth(100);
    }

    public void parseArgs(String[] args) {
        try {
            CommandLine commandLine = commandLineParser.parse(options, args);
            if (commandLine.hasOption("p")) {
                portNumber = Integer.parseInt(commandLine.getOptionValue("p"));
            }
            if (commandLine.hasOption("h")) {
                formatter.printHelp("server", options, true);
                System.exit(0);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
