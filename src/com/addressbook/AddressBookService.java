package com.addressbook;

import java.util.*;

public class AddressBookService
{
    //To scan the input.
    Scanner scanner;
    //To store contacts.
    ArrayList<PersonDetails> contactList;
    //To store multiple addressBook.
    Map<String,ArrayList<PersonDetails>> addressBook;

    //instantiating scanner and ArrayList in constructor.
    public AddressBookService()
    {
        scanner = new Scanner(System.in);
        contactList = new ArrayList<>();
        addressBook = new HashMap<>();
    }

    public void addNewContact()
    {
        System.out.print("Enter how many contacts you want to store at a time : ");
        int enterCount = scanner.nextInt();
        for (int i = 0; i < enterCount; i++)
        {
            PersonDetails contactDetails = new PersonDetails();
            System.out.print("Enter First Name : ");
            String firstName = scanner.next();
            contactDetails.setFirstName(firstName);

            System.out.print("Enter Last Name : ");
            contactDetails.setLastName(scanner.next());

            System.out.print("Enter Address : ");
            contactDetails.setAddress(scanner.next());

            System.out.print("Enter City : ");
            contactDetails.setCity(scanner.next());

            System.out.print("Enter State : ");
            contactDetails.setState(scanner.next());

            System.out.print("Enter ZipCode : ");
            contactDetails.setZipCode(scanner.nextInt());

            System.out.print("Enter Phone-Number : ");
            contactDetails.setPhoneNumber(scanner.nextLong());

            System.out.print("Enter Email-Id : ");
            contactDetails.setEmailId(scanner.next());

            System.out.print("Enter Book name to which you have to add contact : ");
            String bookName  = scanner.next();
            if(addressBook.containsKey(bookName))
            {
                ArrayList<PersonDetails> contactList = addressBook.get(bookName);
                for (int j = 0; j < contactList.size(); j++)
                {
                    if(contactList.get(j).getFirstName() == firstName)
                    {
                        System.out.println("Sorry can not allow duplicate contact :");
                        addNewContact();
                    }
                }
                contactList.add(contactDetails);
                addressBook.put(bookName,contactList);
                System.out.println("New Contact Added Successfully");
            }
            else
            {
                for (int k = 0; k < contactList.size(); k++)
                {
                    if(contactList.get(k).getFirstName() == firstName)
                    {
                        System.out.println("Sorry can not allow duplicate contact :");
                        addNewContact();
                    }
                }
                contactList.add(contactDetails);
                addressBook.put(bookName,contactList);
                System.out.println("New Address-Book created and added Contact Added Successfully");
            }
        }
    }


    public void editFullContact()
    {
        System.out.print("Enter mobile number to select the contact to be edited : ");
        int searchMNumber = scanner.nextInt();
        System.out.println("Select filed number that you want to edit :\n1.Edit First-Name,\n2.Edit Last-Name,\n3.Edit Address,\n4.Edit City.\n5.Edit State,\n6.Edit ZipCode,\n7.Edit Phone-Number,\n8.Edit EmailId.\n");
        int fieldNumber = scanner.nextInt();
        switch(fieldNumber)
        {
            case 1:
                //Edit Fist-Name
                System.out.print("What new first name you want to set : ");
                String editFistName = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setFirstName(editFistName);
                        System.out.println("\nFirst-Name of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 2:
                //Edit Last-Name
                System.out.print("What new last name you want to set : ");
                String editLastName = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setLastName(editLastName);
                        System.out.println("\nLast-Name of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 3:
                //Edit Address
                System.out.print("What new address you want to set : ");
                String editAddress = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setAddress(editAddress);
                        System.out.println("\nAddress of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 4:
                //Edit City
                System.out.print("What new city you want to set : ");
                String editCity = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setCity(editCity);
                        System.out.println("\nCity of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 5:
                //Edit State
                System.out.print("What new state you want to set : ");
                String editState = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setState(editState);
                        System.out.println("\nState of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 6:
                //Edit ZipCode
                System.out.print("What new zipcode you want to set : ");
                int editZipCode = scanner.nextInt();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setZipCode(editZipCode);
                        System.out.println("\nZip-Code of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 7:
                //Edit Mobile-Number
                System.out.print("What new mobile number you want to set : ");
                long editPhoneNumber = scanner.nextLong();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setPhoneNumber(editPhoneNumber);
                        System.out.println("\nMobile-Number of respective contact has been successfully edited.\n");
                    }
                }
                break;
            case 8:
                //Edit Email-id
                System.out.print("What new email-id you want to set : ");
                String editEmailId = scanner.next();
                for(int i = 0; i < contactList.size(); i++)
                {
                    if(contactList.get(i).getPhoneNumber() == searchMNumber)
                    {
                        contactList.get(i).setEmailId(editEmailId);
                        System.out.println("\nEmail-Id of respective contact has been successfully edited.\n");
                    }
                }
                break;
            default:
                System.out.println("Incorrect Entry !");
        }
    }

    public void deleteContact()
    {
        System.out.print("\nGive a mobile number to deleted associated contact : ");
        long searchNumber = scanner.nextLong();
        for(int i = 0; i < contactList.size(); i++)
        {
            if(contactList.get(i).getPhoneNumber() == searchNumber)
            {
                contactList.remove(i);
                System.out.println("\nContact successfully deleted\n");
                break;
            }
            else
            {
                System.out.println("Contact associated with the given mobile number does not exist." +
                        "Enter correct mobile number.");
                deleteContact();
            }
        }
    }

    public void displayContacts()
    {
        for(PersonDetails element : contactList)
        {
            if(element != null)
            {
                System.out.println(element);
            }
        }
    }
}
