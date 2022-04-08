package com.mybatis.entities;

    public class Employee {
        private Integer id;
        private String lastname;
        private String email;
        private Double salary;
        private Department dept;

        public Employee() {
        }

        public Employee(Integer id, String lastname, String email, Double salary, Department dept) {
            this.id = id;
            this.lastname = lastname;
            this.email = email;
            this.salary = salary;
            this.dept = dept;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Department getDept() {
            return dept;
        }

        public void setDept(Department dept) {
            this.dept = dept;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", lastname='" + lastname + '\'' +
                    ", email='" + email + '\'' +
                    ", salary=" + salary +
                    ", dept=" + dept +
                    '}';
        }
    }
