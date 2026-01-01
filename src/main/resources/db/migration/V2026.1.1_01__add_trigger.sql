CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $func$
    BEGIN
        NEW.updated_at = CURRENT_TIMESTAMP;
        RETURN NEW;
    END;
$func$ LANGUAGE 'plpgsql';

CREATE TRIGGER update_users_updated_at
    BEFORE UPDATE ON t_user
    FOR EACH ROW
    EXECUTE PROCEDURE update_updated_at_column();