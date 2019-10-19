package ru.anovikova.lesson17;

public enum Command {
    CREATE(1), SHOW(2), EXIT(3);

    private final int id;

    Command(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Command findById(int id) {
        for (Command command : Command.values()) {
            if (command.id==id) {
                return command;
            }
        }
        throw new IllegalArgumentException("Неизвестный идентификатор команды " + id);
    }
}
