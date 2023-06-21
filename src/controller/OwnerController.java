package controller;

import model.Owner;
import service.OwnerService;

public class OwnerController {
    private OwnerService ownerService = new OwnerService();

    // Create a new owner
    public boolean createOwner(String ownerName, String address, String contact, String username, String password, int adminId, String accountStatus) {
        Owner owner = new Owner(0, ownerName, address, contact, username, password, adminId, accountStatus);
        return ownerService.createOwner(owner);
    }

    // Update an existing owner
    public boolean updateOwner(int ownerId, String ownerName, String address, String contact, String username, String password, int adminId, String accountStatus) {
        Owner owner = new Owner(ownerId, ownerName, address, contact, username, password, adminId, accountStatus);
        return ownerService.updateOwner(owner);
    }

    // Delete an owner
    public boolean deleteOwner(int ownerId) {
        Owner owner = new Owner();
        owner.setOwnerId(ownerId);
        return ownerService.deleteOwner(owner);
    }

    // Show a list of owners
    public void showOwnerList() {
        for (Owner owner : ownerService.listOwners()) {
            System.out.println(owner.getOwnerName());
        }
    }

    public static void main(String[] args) {
        // Creating an instance of OwnerController
        OwnerController ownerController = new OwnerController();
        


    }
}
