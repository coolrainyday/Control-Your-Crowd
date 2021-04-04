package seedu.duke.commands;

import seedu.duke.Duke;
import seedu.duke.exceptions.StorageOperationException;
import seedu.duke.person.TrackingList;
import seedu.duke.storage.StorageFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Moves the storage file to another location in the user's computer.
 */
public class MoveStorageCommand extends Command {

    public static final String COMMAND = "movestorage";
    public static final String TXT_FILE_FORMAT = ".txt";
    private final String newPath;
    public static final String MOVE_MESSAGE = "Moved storage file to %s.txt";

    /**
     * Creates a MoveStorageCommand to move the storage file to another location.
     *
     * @param path new location to store the storage file
     */
    public MoveStorageCommand(String path) {
        this.newPath = path;
    }

    /**
     * Executes the MoveStorageCommand.
     *
     * @param trackingList list of visitors
     * @return a success message to user
     * @throws StorageOperationException if there are problems saving into the file
     */
    @Override
    public CommandOutput execute(TrackingList trackingList) throws StorageOperationException {
        if (Files.exists(Paths.get(newPath + TXT_FILE_FORMAT))) {
            throw new StorageOperationException("Destination path already exists!");
        }

        Duke duke = Duke.getInstance();
        StorageFile newStorage = new StorageFile(newPath);

        // Create the directory by using load
        newStorage.load();
        newStorage.save(trackingList);
        duke.setStorage(newStorage);

        if (duke.getConfigFile() != null) {
            moveConfigPath(duke);
        }
        return new CommandOutput(String.format(MOVE_MESSAGE, newPath), COMMAND);
    }

    private void moveConfigPath(Duke duke) throws StorageOperationException {
        String storageFilePath = duke.getConfigFile().getStorageFilePath();

        // check not null because Paths.get() can't handle null
        if (storageFilePath != null && Files.exists(Paths.get(storageFilePath + TXT_FILE_FORMAT))) {
            deleteOldFile(Paths.get(storageFilePath + TXT_FILE_FORMAT));
        }
        duke.getConfigFile().setStorageFilePath(newPath);
    }

    private void deleteOldFile(Path storageFilePath) throws StorageOperationException {
        try {
            Files.delete(storageFilePath);
        } catch (IOException ioe) {
            throw new StorageOperationException("Unable to delete old storage file!");
        }
    }
}
