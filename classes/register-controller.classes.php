<?php
// error_reporting(0); TODO

class RegisterController extends Register
{
    private $username;
    private $email;
    private $password;
    private $passwordConfirmation;
    private $location = 'location: ../index.php?error=';

    public function __construct($username, $email, $password, $passwordConfirmation)
    {
        $this->username = $username;
        $this->email = $email;
        $this->password = $password;
        $this->passwordConfirmation = $passwordConfirmation;
    }

    public function registerUser()
    {
        if ($this->areAllFieldsFilled() == false) {
            header($this->location . 'empty_input'); // TODO obsłużyć ten komunikat na stronie głównej
            exit();
        }

        if ($this->isEmailValid() == false) {
            header($this->location . 'invalid_email'); // TODO obsłużyć ten komunikat na stronie głównej
            exit();
        }

        if ($this->isPasswordValid() == false) {
            header($this->location . 'invalid_password'); // TODO obsłużyć ten komunikat na stronie głównej
            exit();
        }

        if ($this->arePasswordsEqual() == false) {
            header($this->location . 'different_passwords'); // TODO obsłużyć ten komunikat na stronie głównej
            exit();
        }

        $this->saveUser($this->username, $this->email, $this->password);
    }

    // TODO czy robię inne metody walidujące ???

    private function areAllFieldsFilled()
    {
        if (empty($this->username) | empty($this->email) || empty($this->password) || empty($this->passwordConfirmation)) {
            return false;
        }
        return true;
    }

    private function isUsernameValid()
    {
        // TODO całe
    }

    private function isEmailValid()
    {
        if (!filter_var($this->email, FILTER_VALIDATE_EMAIL)) {
            return false;
        }
        return true;
    }

    private function isPasswordValid()
    {
        if (strlen($this->password) < 8 | strlen($this->password) > 256) {
            return false;
        }
        return true;
    }

    private function arePasswordsEqual()
    {
        if ($this->password !== $this->passwordConfirmation) {
            return false;
        }
        return true;
    }
}