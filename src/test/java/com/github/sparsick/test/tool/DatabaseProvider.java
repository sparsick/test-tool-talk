package com.github.sparsick.test.tool;

public enum DatabaseProvider {
    POSTGRES("postgres:15.1");

    private String dockerImageName;

    DatabaseProvider(String dockerImageName) {
        this.dockerImageName = dockerImageName;
    }

    public String getDockerImageName() {
        return dockerImageName;
    }

    public String getVersion() {
        return dockerImageName.split(":")[1];
    }
}
