CREATE TABLE event_publication (
    id UUID NOT NULL,
    listener_id VARCHAR(512) NOT NULL,
    event_type VARCHAR(512) NOT NULL,
    serialized_event TEXT NOT NULL,
    publication_date TIMESTAMP NOT NULL,
    completion_date TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE INDEX idx_event_publication_by_listener_id ON event_publication (listener_id);
CREATE INDEX idx_event_publication_by_event_type ON event_publication (event_type);
CREATE INDEX idx_event_publication_by_completion_date ON event_publication (completion_date);
