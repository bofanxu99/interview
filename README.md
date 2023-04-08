# Shepherd Money Interview Project

## Introduction

Thanks for your interest in applying to Shepherd Money! Complete this short toy project before your interview to help us evaluate your skills as a software engineer. It shouldn't take more than an hour if you know Spring Boot. We look forward to seeing your work and learning more about you!

## Submission
Create a public repository on Github or Gitlab with the code committed to the `main` branch. Send the repository link to bofanxu@shepherdmoney.com

## Testing and What We Are Looking For
Feel free to test your solution with your own inputs as we don't provide local test cases. To run the project, use the code below. JDK 17 is required, so make sure it's installed on your computer. If you're using Debian Linux, you can install it with `sudo apt install openjdk-17-jdk`.

```bash
./gradlew bootRun
```

We will test your solution by calling the APIs directly. While correctness is important, we are more interested in how you designed the API and your coding practices, such as using clear variable names, good comments, and good naming conventions.

## Project Summary
Write a Spring Boot program that manages user creation/deletion and adding credit cards to their profiles. Users may have zero or more credit cards associated with them. Also, create two APIs: one to get all credit cards for a user and another to find a user by their credit card number.

## Files to Change
- `UserController`
- `CreditCardController`
- `User`
- `CreditCard`
- `UserRepository/CreditCardRepository`

Feel free to create or modify any files, even if they are not listed above.

## Suggested Steps
You may complete the project in any order you prefer, but here are some suggestions:
1. Look at `User` and `CreditCard` file and their respective hints, finish the TODO on associating `User` with `CreditCard`
2. Complete `UserController`
3. Modify `UserRepository/CreditCardRepository`
4. Complete `CreditCardController`

## Useful Tools
- **PostMan**: useful to send http requests to test your API
- **H2 Console**: when running your project, you can use `http://localhost:8080/h2-ui` to access the h2 console. This will allow to look at what's stored in the database.

## Questions?
If you have questions, please reach out to bofanxu@shepherdmoney.com