CREATE TABLE notifications
(
    id      UUID         NOT NULL PRIMARY KEY,
    title   VARCHAR(255) NOT NULL,
    content TEXT         NOT NULL,
    type    VARCHAR(50)  NOT NULL
);

-- Add index on type for better query performance
CREATE INDEX idx_notifications_type ON notifications (type);