//package hust.soict.dsai.test.disc;
//import hust.soict.dsai.aims.aims.media.DigitalVideoDisc;
//public class TestingPassingParameter {
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//
//        swap(jungleDVD, cinderellaDVD);
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//    }
//
//    public static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
////    public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
////        String tmpTilte = o1.getTilte();
////        o1.setTilte(o2.getTilte());
////        o2.setTilte(tmpTilte);
////    }
//    public static void changeTitle(DigitalVideoDisc dvd, String title) {
//        String oldTitle = dvd.getTitle();
//        dvd.setTitle(title);
//        dvd = new DigitalVideoDisc(oldTitle);
//    }
//
//}
