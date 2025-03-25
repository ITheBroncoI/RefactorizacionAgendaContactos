package org.example;

class Contact {
    private String name; // Se ponen las variables en privado, cumpliendo el principio de encapsulamiento
    private String phone;

    // Constructor
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Se agregan setters y getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
