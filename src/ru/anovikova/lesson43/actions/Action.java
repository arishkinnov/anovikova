package ru.anovikova.lesson43.actions;

import java.util.ArrayList;
import java.util.List;

public interface Action {
  String getCode();
  String getDescription();
  List<Action> getActions();
}
