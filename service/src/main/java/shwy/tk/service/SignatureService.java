package shwy.tk.service;

import shwy.tk.pojo.po.SignaturePO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shwy on 2017/10/23.
 */
public interface SignatureService {

    SignaturePO getSignature();

    int updateSignature(SignaturePO signaturePO);

    int addSignature(SignaturePO signaturePO);

    int deleteSignature(Integer id);

    Long getSignatureCount();

    List<SignaturePO> listSignature(HashMap<String, Integer> param);
}
