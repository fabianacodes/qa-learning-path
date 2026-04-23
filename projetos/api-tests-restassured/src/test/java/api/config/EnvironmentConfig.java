package api.config;

public final class EnvironmentConfig {

    private EnvironmentConfig() {}

    /**
     * Prioridade:
     * 1) -DbaseUrl=...
     * 2) variável de ambiente BASE_URL
     * 3) default (genérico)
     */
    public static String baseUrl() {
        String byProp = System.getProperty("baseUrl");
        if (byProp != null && !byProp.isBlank()) return byProp;

        String byEnv = System.getenv("BASE_URL");
        if (byEnv != null && !byEnv.isBlank()) return byEnv;

        return "https://jsonplaceholder.typicode.com";
    }
}