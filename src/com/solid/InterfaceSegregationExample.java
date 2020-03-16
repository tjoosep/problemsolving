package com.solid;

public class InterfaceSegregationExample {
    // No client should be forced to depend on methods it does not use.
}

/* bad example */

// since customer can order fries, or burger, or both, we decided to put all order methods in a single interface
interface OrderService {
    void orderBurgers(int quantity);
    void orderFries(int fries);
    void orderCombo(int quantity, int fries);
}

// now to throw a burger only order, we are forced to throw an exception in the orderFries() method
// this goes the same way with FriesOrderService
class BurgerOrderService implements OrderService {

    @Override
    public void orderBurgers(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void orderFries(int fries) {
        throw new UnsupportedOperationException("No fries in burger only order");
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        throw new UnsupportedOperationException("No combo in burger only order");
    }
}

/*  These classes will also have unwanted side effects whenever we make changes to abstraction / interface
    By violating the ISP, we face the following problems:
        * client developers are confused by the methods they dont need
        * maintenance becomes harder cuz of side effects
        * also violates SRP
 */

/* The magical refactoring */
interface NewBurgerOrderService {
    void orderBurger(int quantity);
}

interface FriesOrderService {
    void orderFries(int fries);
}

class BurgerOrderServiceImpl implements NewBurgerOrderService {

    @Override
    public void orderBurger(int quantity) {
        System.out.println(quantity + " burgers ordered");
    }
}

class FriesOrderServiceImpl implements FriesOrderService {

    @Override
    public void orderFries(int fries) {
        System.out.println(fries + "fries ordered");
    }
}

// nothing to add here basically. everything is quite clean and understandable AND easy to maintain




