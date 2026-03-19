import java.io.*;

public class Exchange {
    public static String Exchanger(String baseCurrency, String targetCurrency, String amount) throws Exception {
        String projectDir = new File(System.getProperty("user.dir")).getParent();
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String pythonExe = isWindows ? "Scripts/python.exe" : "bin/python";
        String pythonPath = projectDir + "/.venv/" + pythonExe;
        String scriptPath = projectDir + "/src/main.py";

        ProcessBuilder pb = new ProcessBuilder(pythonPath, scriptPath, "2", baseCurrency, targetCurrency, amount);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString().trim(); // trim removes the trailing newline
    }

    public static String getAllCurrencies() throws Exception {
        String projectDir = new File(System.getProperty("user.dir")).getParent();
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String pythonExe = isWindows ? "Scripts/python.exe" : "bin/python";
        String pythonPath = projectDir + "/.venv/" + pythonExe;
        String scriptPath = projectDir + "/src/main.py";

        ProcessBuilder pb = new ProcessBuilder(pythonPath, scriptPath, "--list");
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString().trim(); // each currency will be on a new line
    }
}