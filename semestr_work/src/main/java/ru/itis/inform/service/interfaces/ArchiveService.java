package ru.itis.inform.service.interfaces;

import ru.itis.inform.models.Archive;

import java.util.List;

/**
 * Created by artur on 17.12.2016.
 */
public interface ArchiveService {

    Archive getByVendorId(int vendorId);

    Archive getByCustomerId(int customerId);

    List<Archive> getAll();

    void insert(Archive archive);
}
