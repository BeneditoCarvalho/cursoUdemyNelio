package cursoUdemyNelio.exerciciosFixacao.Set.entities;

import java.util.Objects;

public class User implements Comparable<User> {

    private int id;
    private String teste;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(User o) {
        return teste.toUpperCase().compareTo(o.getTeste().toUpperCase());
    }


}
