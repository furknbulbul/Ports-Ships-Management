
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Scanner;

import ports.Port;
import ships.Ship;
import containers.*;
/**
 * class that takes input and creates output file according to simulation.
 * @author FurkanBulbul
 *
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //
        // Main receives two arguments: path to input file and path to output file.
        // You can assume that they will always be provided, so no need to check them.
        // Scanner and PrintStream are already defined for you.
        // Use them to read input and write output.
        //
        // Good Luck!
        //

        Scanner in = new Scanner(new File(args[0]));
        PrintStream out = new PrintStream(new File(args[1]));

        int N=in.nextInt();
        //reading input
        for(int i=0;i<N;i++) {
            int order=in.nextInt();

            if(order==1) {
                int ID=Container.getCountContainer();
                int portID= in.nextInt();
                int weight=in.nextInt();

                if(in.hasNext("R")) {
                    in.next();
                    RefrigeratedContainer c=new RefrigeratedContainer(ID, weight);
                    order1(portID,c);
                    Port.listPorts.get(portID).listRefrigeratedOnPort.add(c);

                }
                else if(in.hasNext("L")) {
                    in.next();
                    LiquidContainer c=new LiquidContainer(ID, weight);
                    order1(portID, c);
                    Port.listPorts.get(portID).listLiquidOnPort.add(c);
                }
                else if(weight>3000) {
                    HeavyContainer c= new HeavyContainer(ID,weight);
                    order1(portID, c);
                    Port.listPorts.get(portID).listHeavyOnPort.add(c);
                }else {
                    BasicContainer c= new BasicContainer(ID,weight);
                    order1(portID, c);
                    Port.listPorts.get(portID).listBasicOnPort.add(c);
                }

            }

            if(order==2) {
                int ID=in.nextInt();int maxWeight=in.nextInt(); int maxAllCont=in.nextInt(); int maxHeavyCont=in.nextInt();
                int maxRefrigeratedCont=in.nextInt(); int maxLiquidCont=in.nextInt(); double fuelKM=in.nextDouble();
                Ship s=new Ship(Ship.getCountShip(),Port.listPorts.get(ID),maxWeight,maxAllCont,maxHeavyCont,maxRefrigeratedCont,maxLiquidCont,fuelKM);
                Ship.listShips.add(s);
            }


            if(order==3) {
                double x=in.nextDouble(); double y=in.nextDouble();
                //order3(x, y);
                Port p=new Port(Port.getCountPort(), x, y);
                Port.listPorts.add(p);
            }

            if(order==4) {
                Ship s = Ship.listShips.get(in.nextInt());
                Container c=Container.listContainers.get(in.nextInt());
                s.load(c);



            }

            if(order==5) {
                Ship s=Ship.listShips.get(in.nextInt());
                Container c=Container.listContainers.get(in.nextInt());
                s.unLoad(c);



            }

            if(order==6) {
                Ship s=Ship.listShips.get(in.nextInt());
                Port p =Port.listPorts.get(in.nextInt());
                s.sailTo(p);


            }

            if(order==7) {
                Ship s=Ship.listShips.get(in.nextInt());
                Double amount=in.nextDouble();
                s.reFuel(amount);

            }
        }


        //print output

        for(int i=0;i<Port.getCountPort();i++) {
            Port p = Port.listPorts.get(i);

            sortOnPort(p);

            out.print("Port "+i+": (");
            out.printf("%.2f",p.getX());out.print(", ");out.printf("%.2f",p.getY());out.println(")");

            //printing containers on port
            if(p.listBasicOnPort.size()>0) {
                out.print("  BasicContainer: ");
                for(int j=0;j<p.listBasicOnPort.size();j++) {
                    out.print(p.listBasicOnPort.get(j).getID()+" ");
                }
                out.println();
            }

            if(p.listHeavyOnPort.size()>0) {
                out.print("  HeavyContainer: ");
                for(int j=0;j<p.listHeavyOnPort.size();j++) {
                    out.print(p.listHeavyOnPort.get(j).getID()+" ");
                }
                out.println();
            }

            if(p.listRefrigeratedOnPort.size()>0) {
                out.print("  RefrigeratedContainer: ");
                for(int j=0;j<p.listRefrigeratedOnPort.size();j++) {
                    out.print(p.listRefrigeratedOnPort.get(j).getID()+" ");
                }
                out.println();
            }

            if(p.listLiquidOnPort.size()>0) {
                out.print("  LiquidContainer: ");
                for(int j=0;j<p.listLiquidOnPort.size();j++) {
                    out.print(p.listLiquidOnPort.get(j).getID()+" ");
                }
                out.println();
            }

            //iterate over ships on port
            for(int j=0; j<p.current.size();j++) {
                Ship sh=p.current.get(j);

                sortOnShip(sh);

                out.print("  Ship "+sh.getID()+": ");
                out.printf("%.2f",sh.getFuel());
                out.println();

                if(sh.listBasicOnShip.size()>0) {
                    out.print("    BasicContainer: ");
                    for(int k=0;k<sh.listBasicOnShip.size();k++) {
                        out.print(sh.listBasicOnShip.get(k).getID()+" ");
                    }
                    out.println();
                }

                if(sh.listHeavyOnShip.size()>0) {
                    out.print("    HeavyContainer: ");
                    for(int k=0; k<sh.listHeavyOnShip.size();k++) {
                        out.print(sh.listHeavyOnShip.get(k).getID()+" ");
                    }
                    out.println();
                }

                if(sh.listRefrigeratedOnShip.size()>0) {
                    out.print("    RefrigeratedContainer: ");
                    for(int k=0;k<sh.listRefrigeratedOnShip.size();k++) {
                        out.print(sh.listRefrigeratedOnShip.get(k).getID()+" ");
                    }
                    out.println();
                }

                if(sh.listLiquidOnShip.size()>0) {
                    out.print("    LiquidContainer: ");
                    for(int k=0;k<sh.listLiquidOnShip.size();k++) {
                        out.print(sh.listLiquidOnShip.get(k).getID()+" ");
                    }
                    out.println();
                }
            }
        }
        //modifying static fields to default for junit
        Port.listPorts.clear();
        Port.setCountPort(0);
        Container.setCountContainer(0);
        Container.listContainers.clear();
        Ship.listShips.clear();
        Ship.setCountShip(0);


        in.close();
        out.close();
    }
    /**
     * implement order 1 situation by  adding container to necessary lists.
     * @param portID id of the port the container should be put.
     * @param cont container created before.
     */
    public static void order1(int portID , Container cont) {
        Port.listPorts.get(portID).containers.add(cont);
        Container.listContainers.add(cont);
    }
    /**
     * sorts the lists that the port has.
     * @param p port whose lists are sorted
     */
    public static void sortOnPort(Port p) {
        Collections.sort(p.containers);
        Collections.sort(p.current);
        Collections.sort(p.listBasicOnPort);
        Collections.sort(p.listHeavyOnPort);
        Collections.sort(p.listRefrigeratedOnPort);
        Collections.sort(p.listLiquidOnPort);
    }
    /**
     * sorts the lists that the ship has.
     * @param s ship whose lists are sorted.
     */
    public static void sortOnShip(Ship s){
        Collections.sort(s.currentContainersOnShip);
        Collections.sort(s.listBasicOnShip);
        Collections.sort(s.listHeavyOnShip);
        Collections.sort(s.listLiquidOnShip);
        Collections.sort(s.listRefrigeratedOnShip);

    }







}







//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

