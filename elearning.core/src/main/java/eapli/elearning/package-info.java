/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/**
 * Main package for the business logic of eCafeteria.
 *
 * <p>
 * The business layer is organized around business areas.
 * </p>
 * <p>
 * <img src="main-biz-packages.svg" alt="main-biz-packages.svg">
 * </p>
 *
 * @author Paulo Gandra Sousa
 *
 *         <!--
 * @startuml main-biz-packages.svg
 *
 *           package CafeteriaUserManagement {
 *           }
 *
 *           package DishManagement {
 *           }
 *
 *           package MealBooking {
 *           }
 *
 *           package MealDelivery {
 *           }
 *           note right of MealDelivery: "not implemented"
 *
 *           package MealExecution {
 *           }
 *           note right of MealExecution: "not implemented"
 *
 *           package MealManagement {
 *           }
 *
 *           package MyCafeteriaUser {
 *           }
 *
 *           package Sales {
 *           }
 *
 *           package Traceability {
 *           }
 *
 *           package UserManagement {
 *           }
 *
 *
 *           MealBooking ..> MealManagement
 *           MealManagement ..> DishManagement
 *           MealBooking ..> CafeteriaUserManagement
 *           Sales ..> CafeteriaUserManagement
 *           MyCafeteriaUser ..> CafeteriaUserManagement
 *           MyCafeteriaUser ..> Sales
 *
 *           MealExecution ..> MealManagement
 *           MealDelivery ..> MealBooking
 *           MealExecution ..> Traceability
 *
 * @enduml
 *         -->
 *
 */
package eapli.elearning;
/*
 *
 * package Infrastructure.Persistence {
 * class PersistenceContext {
 * }
 * }
 *
 * UserManagement ..> PersistenceContext
 * Traceability ..> PersistenceContext
 * Sales ..> PersistenceContext
 * MyCafeteriaUser ..> PersistenceContext
 * MealManagement ..> PersistenceContext
 * MealBooking ..> PersistenceContext
 * DishManagement ..> PersistenceContext
 * CafeteriaUserManagement ..> PersistenceContext
 *
 */