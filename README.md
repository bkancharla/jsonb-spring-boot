# jsonb-spring-boot

**Jsonb data type integration with spring boot**

Usage of postgres sql with spring-boot to create, replace and update(specific fields in jsonb data)

**Technologies used**

1. JDK1.8
2. Spring-boot
3. hibernate-types-52
4. Lombok
5. Postgres Sql

Service Endpoints.

```

  /**
     * This will Create new jsonb field
     */
    @GetMapping("/create/{firstName}")
    public void createNewUser(@PathVariable String firstName) {
        userService.createNewUserWithJsonb(firstName);
    }
    /**
     *User provides all the data
     * curl -X PUT -H "Content-Type: application/json" -d '{"salary": 100000.0, "address": {"city": "columbus", "state": "ohio", "country": "usa"},
     * "children": ["lory", "jack"], "phoneNumber": "333-333-0000"}' http://localhost:8080/createwithalldetails
     * @return
     */
    @PutMapping("/createwithalldetails")
    public Users createUser(@RequestBody PersonalDetails personalDetails) {
        return userService.createNewUserWithAllDetails(personalDetails);
    }

    /**
     * This will update specific part of jsonb
     */
    @GetMapping("/updateaddress/{id}")
    public void updateSpecificUserSalary(@PathVariable int id) {
        userService.updateUserSalary(id);
    }

    /**
     * This will add to  existing array (prepend the data)

     */
    @GetMapping("/updatechilds/{id}")
    public void addToArray(@PathVariable int id) {
        userService.addToArray(id);
    }

    /**
     * This will Remove specific element from existing array
     */
    @GetMapping("/removearray/{id}")
    public void removeFromArray(@PathVariable int id) {
        userService.removeFromChildArray(id);
    }
        /**
     * This will read the data which has given Salary
     * http://localhost:8080/read/200000.0
     *
     * @return
     */
    @GetMapping("/read/{salary}")
    public List<Users> readySalaryContains(@PathVariable double salary) {

        return userService.readSalaryContains(salary);
    }
    
```

**Notes: please update your db details in application.yaml file**