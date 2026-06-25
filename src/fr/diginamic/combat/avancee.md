# Entites
```java
package fr.diginamic.combat;

public abstract class Entites {

    private int force;
    private int pointsDeVie;

    public Entites(int force, int pointsDeVie) {}

    public int calculerAttaque() {
        return force + Utils.genererNombreAleatoire(1, 10);
    }

    public void infligeDegats(int degats) {
        pointsDeVie -= degats;
    }

    public boolean estVivant() {
        return pointsDeVie <= 0;
    }
}
```


## Personnage
```java
package fr.diginamic.combat;

public class Personnage extends Entites {

    private int score;

    public Personnage(int force, int pointsDeVie) {
        super(force, pointsDeVie);
        this.score = 0;
    }

    public void ajouterScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }
}
```

## Creature
```java
package fr.diginamic.combat;

public class Creature extends Entites {

    private String nom;
    private int points;

    public Creature(int force, int pointsDeVie, String nom, int points) {
        super(force, pointsDeVie);
        this.nom = nom;
        this.points = points;
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }
}
```

### Loup
```java
package fr.diginamic.combat;

public class Loup extends Creature {

    public Loup() {
        super(Utils.genererNombreAleatoire(3, 8),
                Utils.genererNombreAleatoire(5, 10),
                "Loup",
                1
        );
    }
}
```

### Gobelin
```java
package fr.diginamic.combat;

public class Gobelin extends Creature {

    public Gobelin() {
        super(Utils.genererNombreAleatoire(5, 10),
                Utils.genererNombreAleatoire(10, 15),
                "Gobelin",
                2
        );
    }
}
```

### Troll
```java
package fr.diginamic.combat;

public class Troll extends Creature {

    public Troll() {
        super(Utils.genererNombreAleatoire(10, 15),
                Utils.genererNombreAleatoire(20, 30),
                "Troll",
                5
        );
    }
}
```

# Utils
```java
package fr.diginamic.combat;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();

    public static int genererNombreAleatoire(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
```