package shwy.tk.dao;

import shwy.tk.pojo.po.SignaturePO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface SignatureDAO {

    SignaturePO getSignaturePO();

    int updateSignature(SignaturePO signaturePO);

    int addSignature(SignaturePO signaturePO);

    int deleteSignature(Integer id);

    Long getSignatureCount();

    List<SignaturePO> listSignature(HashMap<String, Integer> param);

}
