package TestsWithFluentAPI;

import DataObjects.models.Developer;

import java.util.ArrayList;
import java.util.List;

class DeveloperBuilder {
    private String email;
    private String name;

    private final List<String> languages = new ArrayList<>();

    public DeveloperBuilder email(String email) {
        if (email == null || email.length() == 0) {
            throw new IllegalArgumentException("email musn't be null/empty");
        }

        this.email = email;

        return this;
    }

    public DeveloperBuilder name(String name) {
        this.name = name;
        return this;
    }

    public DeveloperBuilder language(String lang) {
        if (lang == null || lang.length() == 0) {
            throw new IllegalArgumentException("lang musn't be null/empty");
        }

        if (this.languages.contains(lang)) {
            return this;
        }

        this.languages.add(lang);

        return this;
    }

    public Developer build() {
        if (email == null || email.length() == 0) {
            throw new IllegalStateException("email is a required field");
        }
        Developer developer = new Developer();
        developer.setEmail(this.email);
        developer.setName(this.name);
        developer.setLanguages(this.languages);
        return developer;
    }
    Developer validDev =
            new DeveloperBuilder()
                    .email("ben@example.com")
                    .name("Ben Weidig")
                    .language("Java")
                    .language("Swift")
                    .language("Golang")
                    .build();

    Developer invalidDev1 =
            new DeveloperBuilder().name("Ben Weidig")
                    .language("Java")
                    .language("Swift")
                    .language("Golang")
                    // throws IllegalStateException
                    .build();

    Developer invalidDev2 =
            new DeveloperBuilder().email("ben@example.com")
                    .name("Ben Weidig")
                    // throws IllegalArgumentException
                    .language(null)
                    .language("Swift")
                    .language("Golang")
                    .build();
}

