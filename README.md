### Project Description

Fernando is an experienced event organizer who owns a party venue. To streamline the management of his activities, he wishes to develop a system that allows for the complete management of the parties held at his venue. The system will be divided into two main interfaces: one for the administrator (Fernando) and another for the clients.

### System Features

#### For Fernando (Administrator):
- **Party Management:** Fernando will be able to register, edit, and view the parties scheduled at his venue. He will have access to the details of each event, including the date, time, clients involved, and the staff assigned.
- **Employee Management:** Fernando can assign specific employees to each party based on their availability and the event’s needs. He can also manage employee records, including personal and salary information.
- **Contract Management:** The administrator will have access to the contracts for each party, where he can review details such as the responsible client, contract status, and agreed-upon fees.
- **Control Panel:** A dashboard providing an overview of scheduled parties, contract statuses, available employees, and other key metrics for venue management.

#### For Clients:
- **Registration and Access:** Clients can register in the system by providing essential personal information such as name, CPF (Brazilian individual taxpayer registry), RG (general registration), marital status, address, phone number, email, and password.
- **Party Booking:** After registration, clients can schedule parties at Fernando’s venue, choosing from available dates and times.
- **Employee Assignment:** Clients can select and assign employees to their party, provided the employees are available for the chosen date and time.
- **Party Status Tracking:** Clients will have detailed access to the status of their event, including confirmation of assigned employees and contract status.

### Data Structure

#### Client:
- **id:** Unique identifier for the client.
- **name:** Client’s full name.
- **cpf:** Client’s CPF (individual taxpayer registry).
- **rg:** Client’s RG (general registration).
- **marital_status:** Client’s marital status.
- **phone:** Client’s phone number.
- **address:** Client’s residential address.
- **email:** Client’s email address.
- **password:** Client’s system access password.

#### Administrator (Fernando):
- **id:** Unique identifier for the administrator.
- **name:** Administrator’s full name.
- **email:** Administrator’s email address.
- **phone:** Administrator’s phone number.
- **venue_address:** Address of the party venue.
- **cnpj:** CNPJ (business registration number) of the venue.

#### Party:
- **id:** Unique identifier for the party.
- **contract_id:** Identifier for the contract associated with the party.
- **client_id:** Identifier for the client responsible for the party.
- **lessee_name:** Name of the client renting the venue.
- **lessor_name:** Name of Fernando, the venue administrator.
- **start_date:** Start date of the party.
- **end_date:** End date of the party.
- **start_time:** Start time of the party.
- **end_time:** End time of the party.
- **employee_ids:** List of employee identifiers assigned to the party.
- **status:** Current status of the party (scheduled, in progress, completed, canceled, etc.).

#### Contract:
- **id:** Unique identifier for the contract.
- **party_id:** Identifier for the party associated with the contract.
- **employee_ids:** List of employee identifiers involved in the contract.
- **client_id:** Identifier for the responsible client.
- **client_name:** Name of the client.
- **client_cpf:** Client’s CPF (individual taxpayer registry).
- **client_rg:** Client’s RG (general registration).
- **admin_cnpj:** CNPJ (business registration number) of the venue.
- **admin_phone:** Administrator’s phone number.
- **client_phone:** Client’s phone number.
- **start_date:** Start date of the contract validity.
- **end_date:** End date of the contract validity.
- **start_time:** Start time of the contract.
- **end_time:** End time of the contract.
- **total_amount:** Total amount agreed upon in the contract.

#### Employee:
- **id:** Unique identifier for the employee.
- **name:** Employee’s full name.
- **role:** Employee’s role (waiter, cook, bartender, security, DJ, cleaner).
- **cpf:** Employee’s CPF (individual taxpayer registry).
- **rg:** Employee’s RG (general registration).
- **salary:** Employee’s base salary.
- **hourly_rate:** Hourly rate of pay for the employee.

