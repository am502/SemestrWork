package ru.itis.inform.service.impl;

import ru.itis.inform.dao.impl.ArchiveDaoImpl;
import ru.itis.inform.dao.interfaces.ArchiveDao;
import ru.itis.inform.models.Archive;
import ru.itis.inform.service.interfaces.ArchiveService;

import java.util.List;

/**
 * Created by artur on 17.12.2016.
 */
public class ArchiveServiceImpl implements ArchiveService {

    ArchiveDao archiveDao = new ArchiveDaoImpl();

    @Override
    public Archive getByVendorId(int vendorId) {
        return archiveDao.getByVendorId(vendorId);
    }

    @Override
    public Archive getByCustomerId(int customerId) {
        return archiveDao.getByCustomerId(customerId);
    }

    @Override
    public List<Archive> getAll() {
        return archiveDao.getAll();
    }

    @Override
    public void insert(Archive archive) {
        archiveDao.insert(archive);
    }
}
