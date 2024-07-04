package com.kys.myjpa;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {

    @Override
    public IPhoneBook findById(Long id) {
//        for ( IPhoneBook obj : this.list ) {
//            if ( id.equals(obj.getId()) ) {
//                return obj;
//            }
//        }
//        return null;
        Optional<IPhoneBook> find = this.list.stream().parallel()
                .filter(item -> id.equals(item.getId())).findAny();
        return find.orElse(null);
    }

    private int findIndexById(Long id) {
//        for ( int i = 0; i < this.list.size(); i++ ) {
//            if ( id.equals(this.list.get(i).getId()) ) {
//                return i;
//            }
//        }
//        return -1;
        IPhoneBook find = PhoneBookDto.builder().id(id).build();
        int findIndex = Arrays.binarySearch(this.list.toArray(IPhoneBook[]::new)
                , find
                , PhoneBookDto.ORDER_GREAT);
        return findIndex;
    }

    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public boolean insert(String name, ECategory group, String phoneNumber, String email) throws Exception {
        IPhoneBook phoneBook = PhoneBookDto.builder()
                .id(this.getMaxId())
                .name(name).group(group)
                .phoneNumber(phoneNumber).email(email).build();
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        this.list.add(phoneBook);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find != null ) {
            this.list.remove(find);
            return true;
        }
        return false;
    }

    private boolean setIphoneBookIsNotNull(IPhoneBook to, IPhoneBook from) {
        if ( to == null || from == null ) {
            return false;
        }
        if ( from.getName() != null && !from.getName().isEmpty() ) {
            to.setName(from.getName());
        }
        if ( from.getCategory() != null ) {
            to.setCategory(from.getCategory());
        }
        if ( from.getPhoneNumber() != null && !from.getPhoneNumber().isEmpty() ) {
            to.setPhoneNumber(from.getPhoneNumber());
        }
        if ( from.getEmail() != null && !from.getEmail().isEmpty() ) {
            to.setEmail(from.getEmail());
        }
        return true;
    }

    @Override
    public boolean update(Long id, IPhoneBook phoneBook) {
        IPhoneBook find = this.findById(id);
        int findIndex = this.findIndexById(id);
        if ( findIndex >= 0 ) {
//            ((PhoneBookDto)find).copyFields(phoneBook);
//            this.list.set(findIndex, find);
//            return true;
            if (this.setIphoneBookIsNotNull(find, phoneBook)) {
                this.list.set(findIndex, find);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getName().contains(findName)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getName().contains(findName))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromGroup(ECategory phoneGroup) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneGroup.equals(phoneBook.getCategory()())) {
//                findArr.add(phoneBook);
//            }
//        }
//        return findArr;
        if (phoneGroup == null) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()//.parallel()
                .filter(item -> item.getCategory().equals(phoneGroup))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getPhoneNumber().contains(findPhone)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findPhone == null || findPhone.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getPhoneNumber().contains(findPhone))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
//        List<IPhoneBook> findArr = new ArrayList<>();
//        for ( IPhoneBook phoneBook : this.list ) {
//            if (phoneBook.getEmail().contains(findEmail)) {
//                findArr.add(phoneBook);
//            }
//        }
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        List<IPhoneBook> findArr = this.list.stream()
                .filter(item -> item.getEmail().contains(findEmail))
                .collect(Collectors.toUnmodifiableList());
        return findArr;
    }

}
