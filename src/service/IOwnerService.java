package service;
import java.util.ArrayList;
import model.Owner;

public interface IOwnerService {
    public boolean createOwner(Owner owner);
    public boolean updateOwner(Owner owner);
    public boolean deleteOwner(Owner owner);
    public ArrayList<Owner> listOwners();
}
