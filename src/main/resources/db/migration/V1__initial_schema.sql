-- ===============================
-- USERS TABLE
-- ===============================
CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    isActive BOOL NOT NULL
);

-- ===============================
-- ROLES TABLE
-- ===============================
CREATE TABLE Roles (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

-- ===============================
-- USERROLES TABLE
-- ===============================
CREATE TABLE UserRoles (
    id BIGSERIAL PRIMARY KEY,
    userId BIGINT NOT NULL REFERENCES Users(id) ON DELETE CASCADE,
    roleId BIGINT NOT NULL REFERENCES Roles(id) ON DELETE CASCADE
);

-- ===============================
-- OWNERS TABLE
-- ===============================
CREATE TABLE Owners (
    id BIGSERIAL PRIMARY KEY,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    phone TEXT,
    email TEXT NOT NULL,
    address TEXT,
    createdAt DATE
);

-- ===============================
-- SPECIES TABLE
-- ===============================
CREATE TABLE Species (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

-- ===============================
-- BREEDS TABLE
-- ===============================
CREATE TABLE Breeds (
    id BIGSERIAL PRIMARY KEY,
    speciesId BIGINT NOT NULL REFERENCES Species(id) ON DELETE CASCADE,
    name TEXT NOT NULL
);

-- ===============================
-- PETS TABLE
-- ===============================
CREATE TABLE Pets (
    id BIGSERIAL PRIMARY KEY,
    ownerId BIGINT NOT NULL REFERENCES Owners(id) ON DELETE CASCADE,
    name TEXT NOT NULL,
    speciesId BIGINT NOT NULL REFERENCES Species(id) ON DELETE CASCADE,
    breedId BIGINT NOT NULL REFERENCES Breeds(id) ON DELETE CASCADE,
    gender TEXT,
    birthDate DATE,
    color TEXT
);

-- ===============================
-- APPOINTMENTS TABLE
-- ===============================
CREATE TABLE Appointments (
    id BIGSERIAL PRIMARY KEY,
    petId BIGINT NOT NULL REFERENCES Pets(id) ON DELETE CASCADE,
    userId BIGINT NOT NULL REFERENCES Users(id) ON DELETE CASCADE,
    appointmentDate DATE NOT NULL,
    reason TEXT NOT NULL,
    status TEXT NOT NULL
);

-- ===============================
-- VISITS TABLE
-- ===============================
CREATE TABLE Visits (
    id BIGSERIAL PRIMARY KEY,
    petId BIGINT NOT NULL REFERENCES Pets(id) ON DELETE CASCADE,
    attendingVeterinarianId BIGINT NOT NULL REFERENCES Users(id) ON DELETE CASCADE,
    appointmentId BIGINT REFERENCES Appointments(id) ON DELETE CASCADE,
    visitDate DATE NOT NULL,
    weight TEXT NOT NULL,
    temperature TEXT NOT NULL,
    notes TEXT NOT NULL
);

-- ===============================
-- DIAGNOSIS TABLE
-- ===============================
CREATE TABLE Diagnoses (
    id BIGSERIAL PRIMARY KEY,
    visitId BIGINT NOT NULL REFERENCES Visits(id) ON DELETE CASCADE,
    description TEXT NOT NULL,
    severity TEXT NOT NULL
);

-- ===============================
-- TREATMENTS TABLE
-- ===============================
CREATE TABLE Treatments (
    id BIGSERIAL PRIMARY KEY,
    visitId BIGINT NOT NULL REFERENCES Visits(id) ON DELETE CASCADE,
    treatmentName TEXT NOT NULL,
    cost TEXT NOT NULL,
    notes TEXT NOT NULL
);

-- ===============================
-- MEDICATIONS TABLE
-- ===============================
CREATE TABLE Medications (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    dosageForm TEXT NOT NULL,
    strength TEXT NOT NULL,
    manufacturer TEXT NOT NULL
);

-- ===============================
-- PRESCRIPTION TABLE
-- ===============================
CREATE TABLE Prescriptions (
    id BIGSERIAL PRIMARY KEY,
    visitId BIGINT NOT NULL REFERENCES Visits(id) ON DELETE CASCADE,
    issueDate DATE NOT NULL,
    notes TEXT NOT NULL
);

-- ===============================
-- PRESCRIPTION ITEMS TABLE
-- ===============================
CREATE TABLE PrescriptionItems (
    id BIGSERIAL PRIMARY KEY,
    prescriptionId BIGINT NOT NULL REFERENCES Prescriptions(id) ON DELETE CASCADE,
    medicationId BIGINT NOT NULL REFERENCES Medications(id) ON DELETE CASCADE,
    dosage TEXT NOT NULL
);

-- ===============================
-- VACCINES TABLE
-- ===============================
CREATE TABLE Vaccines (
    id BIGSERIAL PRIMARY KEY,
    speciesId BIGINT NOT NULL REFERENCES Species(id) ON DELETE CASCADE,
    name TEXT NOT NULL,
    requiredIntervalMonths INT NOT NULL
);

-- ===============================
-- VACCINATIONS TABLE
-- ===============================
CREATE TABLE Vaccinations (
    id BIGSERIAL PRIMARY KEY,
    petId BIGINT NOT NULL REFERENCES Pets(id) ON DELETE CASCADE,
    vaccineId BIGINT NOT NULL REFERENCES Vaccines(id) ON DELETE CASCADE,
    veterinarianId BIGINT NOT NULL REFERENCES Users(id) ON DELETE CASCADE,
    vaccinationDate DATE NOT NULL,
    nextDueDate DATE NOT NULL
);

-- ===============================
-- INVOICES TABLE
-- ===============================
CREATE TABLE Invoices (
    id BIGSERIAL PRIMARY KEY,
    visitId BIGINT NOT NULL REFERENCES Visits(id) ON DELETE CASCADE,
    totalAmount DECIMAL NOT NULL,
    status TEXT NOT NULL,
    issueDate DATE NOT NULL
);