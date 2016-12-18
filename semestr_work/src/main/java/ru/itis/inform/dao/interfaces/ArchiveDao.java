package ru.itis.inform.dao.interfaces;

import ru.itis.inform.models.Archive;

import java.util.List;

/**
 * Created by artur on 08.11.16.
 */
public interface ArchiveDao {

    Archive getByVendorId(int vendorId);

    Archive getByCustomerId(int customerId);

    List<Archive> getAll();

    void insert(Archive archive);
}
