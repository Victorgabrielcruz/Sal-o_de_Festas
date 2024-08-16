### Business Logic

### 1. **User Registration and Authentication**

**Rule:**  
- Clients and the administrator (Fernando) must register with detailed information such as name, email, CPF/CNPJ, address, etc.
- The system must check if the CPF/CNPJ is already registered before allowing a new registration.
- Authentication should be done using email and password.

**Process:**  
1. The client/administrator accesses the registration screen.
2. Fills in the necessary information and submits it.
3. The system verifies the uniqueness of the CPF/CNPJ.
4. If the CPF/CNPJ is unique, the system creates the new user and sends a confirmation email.
5. The user confirms their email and can then access the system using email and password.

### 2. **Party Management**

**Rule:**  
- Only the administrator can create and manage parties in the system.
- Clients can request the creation of a party, but it must be approved by the administrator.
- Each party must have an associated contract, and this contract should contain all the details of the party and the involved parties (client, employees, etc.).

**Process:**
1. The client requests a new party by specifying the date, time, and basic details.
2. The system notifies the administrator about the request.
3. The administrator reviews the request and can approve or reject it.
   - If approved, the administrator creates an associated contract and sets the party's status as "Scheduled."
   - If rejected, the client is notified and can edit or cancel the request.
4. The administrator can later edit the party details, such as dates, times, assigned employees, etc.
5. At any time, the administrator can change the party's status (e.g., in progress, completed, canceled).

### 3. **Contract Management**

**Rule:**  
- Each party must have a formal contract that includes all event details, costs, and service terms.
- The contract must be automatically generated when a party is approved by the administrator.
- The contract can only be edited by the administrator.

**Process:**
1. After the party is approved, the system automatically generates a contract based on the provided details.
2. The administrator reviews and, if necessary, edits the contract.
3. The client is notified to review the contract.
4. The client accepts the contract terms, after which it is finalized and can no longer be edited.
5. The contract remains accessible to both the client and the administrator until the party is concluded.

### 4. **Employee Assignment**

**Rule:**  
- Employees can be assigned to parties as long as they are available on the requested date and time.
- The administrator has the final authority to assign or replace employees.

**Process:**
1. The client selects the desired employees when requesting the party.
2. The system checks the availability of the employees on the chosen date and time.
3. If available, the employees are pre-assigned.
4. The administrator reviews the employee assignments and can confirm or modify them.
5. Once confirmed, the assignment is finalized, and the employees are notified.

### 5. **Party and Contract Status Management**

**Rule:**  
- The party status (e.g., scheduled, in progress, completed, canceled) must reflect the current state of the event.
- The contract status (e.g., pending, confirmed, canceled) must reflect the agreement between the client and the administrator.

**Process:**
1. The system assigns the status "Scheduled" when the administrator approves the party.
2. On the day of the party, the status automatically changes to "In Progress" when the party starts.
3. After the party ends, the administrator manually marks the party as "Completed."
4. If the party is canceled by the client or administrator, the status is changed to "Canceled," and the employees are unassigned.
5. The contract follows a similar cycle, starting as "Pending" until the client confirms it, at which point the contract is marked as "Confirmed." If canceled, the contract status is set to "Canceled."

### 6. **Reports and Dashboards**

**Rule:**  
- The administrator must have access to reports on parties, contracts, and employees to help manage the venue.
- Clients should have an overview of their parties and contracts in a simplified dashboard.

**Process:**
1. The system generates periodic reports (daily, weekly, monthly) on the number of scheduled parties, contract statuses, and hours worked by employees.
2. The administrator can access these reports in the control panel, where they can filter data and make informed decisions.
3. Clients have a dashboard showing scheduled parties, contract statuses, and the history of past parties.
