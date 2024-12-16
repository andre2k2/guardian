package com.github.andre2k2.guardian;

import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    public Project loadProject(String projectPath) {
        return new Project(null);
    }

}
