package players;

import exceptions.InsufficientChipsException;

public interface PlayerActions {
    void hit(int handIndex);
    void stand(int handIndex);
    void doubleDown(int handIndex) throws InsufficientChipsException;
    void split(int handIndex);
}
