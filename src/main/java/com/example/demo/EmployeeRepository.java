package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
// org.springframework.data.jpa.repository.config.JpaRepositoriesRegistrar;

/* 
 * NOTE: Using a paging repository will be useful for large employee numbers
 *      But exercise limits to JPA?
 *      Pageable is a possible param to repository funcs
 */
interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // TODO: Generate name / role REST APIs
    // Name use IgnoreCase method suffix
}