Design Amazon

############# How to think about functional requirements ####################
Step 1: Think of the actors who are going to use your system
Step 2: For each actor think about the happy path.
Step 3: For each actor think about the unhappy path.
Step 4 : Summarize the above 3 points and write your functional requirements

################### Functional Requirements ##########################

1) Customer should be able to browser product by name and category.
2) Customer should be able to add any product for the list of products to their cart.
3) Customer should be able to add, update, or remove any items from cart.
4) Cart should show total, subtotal to the user.
5) Customer should be able to choose payment options to pay.
6) Customer should be able to place order for the items in the cart, if not then system should display any issue like ItemOutOfStock
7) System should verify before placing order about quantity the user has requested and must update the stock in the inventory
8) Customer should be able to see their orderHistory.


################## NonFunctional Requirements ######################
Modularity: The system should consist of well-separated components
Extensibility: The design should allow for future features like seller dashboards, product reviews, wishlists, and delivery tracking
Consistency: Inventory and order placement should be transactionally consistent to avoid overselling
Maintainability: The code should be organized, testable, and easy to extend


