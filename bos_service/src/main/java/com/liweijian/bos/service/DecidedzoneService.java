package com.liweijian.bos.service;

import com.liweijian.bos.domain.Decidedzone;
import com.liweijian.bos.utils.PageBean; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:12 2018/3/15 0015
 */
public interface DecidedzoneService {
    void save(Decidedzone model, String[] subareaid);

    void quaryPage(PageBean pageBean);
}
