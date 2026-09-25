package com.example.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private Sprites sprites;
    private List<TypeSlot> types;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public Sprites getSprites() { return sprites; }
    public void setSprites(Sprites sprites) { this.sprites = sprites; }

    public List<TypeSlot> getTypes() { return types; }
    public void setTypes(List<TypeSlot> types) { this.types = types; }

    // Estructura interna para navegar el JSON hasta la imagen Official Artwork HD
    public static class Sprites {
        private String front_default;
        private Other other;

        public String getFront_default() { return front_default; }
        public void setFront_default(String front_default) { this.front_default = front_default; }

        public Other getOther() { return other; }
        public void setOther(Other other) { this.other = other; }

        public static class Other {
            @JsonProperty("official-artwork")
            private OfficialArtwork officialArtwork;

            public OfficialArtwork getOfficialArtwork() { return officialArtwork; }
            public void setOfficialArtwork(OfficialArtwork officialArtwork) { this.officialArtwork = officialArtwork; }

            public static class OfficialArtwork {
                private String front_default;

                public String getFront_default() { return front_default; }
                public void setFront_default(String front_default) { this.front_default = front_default; }
            }
        }
    }

    public static class TypeSlot {
        private Type type;

        public Type getType() { return type; }
        public void setType(Type type) { this.type = type; }

        public static class Type {
            private String name;

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
    }
}