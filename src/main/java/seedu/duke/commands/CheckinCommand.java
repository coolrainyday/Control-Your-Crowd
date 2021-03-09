package seedu.duke.commands;

/**
 * Check-in a person.
 */
public class CheckinCommand extends Command {

    public static final String COMMAND = "checkin";
    public static final String CHECKIN_MESSAGE = "%s has been successfully checked-in!";
    private Person toCheckin;

    /**
     * Checkin using raw values (first time).
     * If already checkin, update the location list.
     */
    public CheckinCommand(String id,
                          String name,
                          String phone,
                          String location) {
        if (trackingList.findPerson(id)) {
            toCheckin = trackinglist.findPerson(id);
            toCheckin.addLocation(location);
        }
        toCheckin = new Person(
                new Id(id),
                new Name(name),
                new Phone(phone),
                new Locations(visitedPlaces)
        );
    }

    @Override
    public CommandOutput execute() {
        trackingList.add(toCheckin);
        return new CommandOutput(String.format(CHECKIN_MESSAGE, toCheckin));
    }

}
