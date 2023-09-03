# simple-library-app

This is a very simple terminal based library application which I made for software modelling class in University.

The app basically allows a librarian to track the items that been borrowed by students, staff or faculties. The library offers books, videos, journals and technical papers which has their own unique ID along with a title and description.

When a borrower borrows an item, they will provide their ID along the ID of the item.

Then the app adds a lend record where the deadline for the lending ends after two weeks.

Any borrower can lend up to five items. They can return their item if they want to borrow another item (if the maximum of lent items has reached).

If an item is returned after their due date, the borrower will be charged a fine, based on the type of the item (books $3/day, journals $3/day, videos $1/day, technical paper $2/day). The app will automatically calculate the total fine.

The app also prints (to the terminal) a table showing all the lent items along with their due dates and total fines.

Since the app was made for a software modelling class, the goal of the app was mostly implementing some design patterns to it

The code might not be that great of use, but feel free to use it.
