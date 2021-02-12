# jsonb-spring-boot

**Jsonb data type integration with spring boot**

Usage of postgres sql with spring -boot to create ,replace and update(specific fields in jsonb data)

**Technologies used**
1.JDK1.8

2. Spring-boot
3. hibernate-types-52<
4. Lombok
5. Postgres Sql

Service Endpoints.


    /**
     * This will Create new jsonb field
     */
    @GetMapping("/create/{firstName}")
    public void createNewUser(@PathVariable String firstName) {
        userService.createNewUserWithJsonb(firstName);
    }

    /**
     * This will update specific part of jsonb
     */
    @GetMapping("/updateaddress/{id}")
    public void updateSpecificUserSalary(@PathVariable int id) {
        userService.updateUserSalary(id);
    }

