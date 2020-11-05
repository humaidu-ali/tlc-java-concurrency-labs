package com.company;

import java.util.ArrayList;

public class LettersImplementation implements Letters {
    private ArrayList<Character> lettersList;

    public LettersImplementation() {
        this.lettersList = new ArrayList<>();
    }

    @Override
    public void addLetter(char c) {
        this.lettersList.add(c);
    }

    @Override
    public char takeLetter() {
        return this.lettersList.remove(lettersList.size() - 1);
    }
}
