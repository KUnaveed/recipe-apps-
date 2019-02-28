
package brunel.group28.cookking.edamam.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import Raj.com.Model.Nutrients.CA_;
import Raj.com.Model.Nutrients.CHOCDF_;
import Raj.com.Model.Nutrients.CHOLE_;
import Raj.com.Model.Nutrients.ENERCKCAL_;
import Raj.com.Model.Nutrients.FASAT_;
import Raj.com.Model.Nutrients.FAT_;
import Raj.com.Model.Nutrients.FE_;
import Raj.com.Model.Nutrients.FIBTG_;
import Raj.com.Model.Nutrients.FOLDFE_;
import Raj.com.Model.Nutrients.K_;
import Raj.com.Model.Nutrients.MG_;
import Raj.com.Model.Nutrients.NA_;
import Raj.com.Model.Nutrients.NIA_;
import Raj.com.Model.Nutrients.PROCNT_;
import Raj.com.Model.Nutrients.P_;
import Raj.com.Model.Nutrients.RIBF_;
import Raj.com.Model.Nutrients.THIA_;
import Raj.com.Model.Nutrients.TOCPHA_;
import Raj.com.Model.Nutrients.VITARAE_;
import Raj.com.Model.Nutrients.VITB12_;
import Raj.com.Model.Nutrients.VITB6A_;
import Raj.com.Model.Nutrients.VITC_;
import Raj.com.Model.Nutrients.VITD_;
import Raj.com.Model.Nutrients.VITK1_;
import Raj.com.Model.Nutrients.ZN_;

public class TotalDaily {

    @SerializedName("ENERC_KCAL")
    @Expose
    private ENERCKCAL_ eNERCKCAL;
    @SerializedName("FAT")
    @Expose
    private FAT_ fAT;
    @SerializedName("FASAT")
    @Expose
    private FASAT_ fASAT;
    @SerializedName("CHOCDF")
    @Expose
    private CHOCDF_ cHOCDF;
    @SerializedName("FIBTG")
    @Expose
    private FIBTG_ fIBTG;
    @SerializedName("PROCNT")
    @Expose
    private PROCNT_ pROCNT;
    @SerializedName("CHOLE")
    @Expose
    private CHOLE_ cHOLE;
    @SerializedName("NA")
    @Expose
    private NA_ nA;
    @SerializedName("CA")
    @Expose
    private CA_ cA;
    @SerializedName("MG")
    @Expose
    private MG_ mG;
    @SerializedName("K")
    @Expose
    private K_ k;
    @SerializedName("FE")
    @Expose
    private FE_ fE;
    @SerializedName("ZN")
    @Expose
    private ZN_ zN;
    @SerializedName("P")
    @Expose
    private P_ p;
    @SerializedName("VITA_RAE")
    @Expose
    private VITARAE_ vITARAE;
    @SerializedName("VITC")
    @Expose
    private VITC_ vITC;
    @SerializedName("THIA")
    @Expose
    private THIA_ tHIA;
    @SerializedName("RIBF")
    @Expose
    private RIBF_ rIBF;
    @SerializedName("NIA")
    @Expose
    private NIA_ nIA;
    @SerializedName("VITB6A")
    @Expose
    private VITB6A_ vITB6A;
    @SerializedName("FOLDFE")
    @Expose
    private FOLDFE_ fOLDFE;
    @SerializedName("VITB12")
    @Expose
    private VITB12_ vITB12;
    @SerializedName("VITD")
    @Expose
    private VITD_ vITD;
    @SerializedName("TOCPHA")
    @Expose
    private TOCPHA_ tOCPHA;
    @SerializedName("VITK1")
    @Expose
    private VITK1_ vITK1;

    public ENERCKCAL_ getENERCKCAL() {
        return eNERCKCAL;
    }

    public void setENERCKCAL(ENERCKCAL_ eNERCKCAL) {
        this.eNERCKCAL = eNERCKCAL;
    }

    public FAT_ getFAT() {
        return fAT;
    }

    public void setFAT(FAT_ fAT) {
        this.fAT = fAT;
    }

    public FASAT_ getFASAT() {
        return fASAT;
    }

    public void setFASAT(FASAT_ fASAT) {
        this.fASAT = fASAT;
    }

    public CHOCDF_ getCHOCDF() {
        return cHOCDF;
    }

    public void setCHOCDF(CHOCDF_ cHOCDF) {
        this.cHOCDF = cHOCDF;
    }

    public FIBTG_ getFIBTG() {
        return fIBTG;
    }

    public void setFIBTG(FIBTG_ fIBTG) {
        this.fIBTG = fIBTG;
    }

    public PROCNT_ getPROCNT() {
        return pROCNT;
    }

    public void setPROCNT(PROCNT_ pROCNT) {
        this.pROCNT = pROCNT;
    }

    public CHOLE_ getCHOLE() {
        return cHOLE;
    }

    public void setCHOLE(CHOLE_ cHOLE) {
        this.cHOLE = cHOLE;
    }

    public NA_ getNA() {
        return nA;
    }

    public void setNA(NA_ nA) {
        this.nA = nA;
    }

    public CA_ getCA() {
        return cA;
    }

    public void setCA(CA_ cA) {
        this.cA = cA;
    }

    public MG_ getMG() {
        return mG;
    }

    public void setMG(MG_ mG) {
        this.mG = mG;
    }

    public K_ getK() {
        return k;
    }

    public void setK(K_ k) {
        this.k = k;
    }

    public FE_ getFE() {
        return fE;
    }

    public void setFE(FE_ fE) {
        this.fE = fE;
    }

    public ZN_ getZN() {
        return zN;
    }

    public void setZN(ZN_ zN) {
        this.zN = zN;
    }

    public P_ getP() {
        return p;
    }

    public void setP(P_ p) {
        this.p = p;
    }

    public VITARAE_ getVITARAE() {
        return vITARAE;
    }

    public void setVITARAE(VITARAE_ vITARAE) {
        this.vITARAE = vITARAE;
    }

    public VITC_ getVITC() {
        return vITC;
    }

    public void setVITC(VITC_ vITC) {
        this.vITC = vITC;
    }

    public THIA_ getTHIA() {
        return tHIA;
    }

    public void setTHIA(THIA_ tHIA) {
        this.tHIA = tHIA;
    }

    public RIBF_ getRIBF() {
        return rIBF;
    }

    public void setRIBF(RIBF_ rIBF) {
        this.rIBF = rIBF;
    }

    public NIA_ getNIA() {
        return nIA;
    }

    public void setNIA(NIA_ nIA) {
        this.nIA = nIA;
    }

    public VITB6A_ getVITB6A() {
        return vITB6A;
    }

    public void setVITB6A(VITB6A_ vITB6A) {
        this.vITB6A = vITB6A;
    }

    public FOLDFE_ getFOLDFE() {
        return fOLDFE;
    }

    public void setFOLDFE(FOLDFE_ fOLDFE) {
        this.fOLDFE = fOLDFE;
    }

    public VITB12_ getVITB12() {
        return vITB12;
    }

    public void setVITB12(VITB12_ vITB12) {
        this.vITB12 = vITB12;
    }

    public VITD_ getVITD() {
        return vITD;
    }

    public void setVITD(VITD_ vITD) {
        this.vITD = vITD;
    }

    public TOCPHA_ getTOCPHA() {
        return tOCPHA;
    }

    public void setTOCPHA(TOCPHA_ tOCPHA) {
        this.tOCPHA = tOCPHA;
    }

    public VITK1_ getVITK1() {
        return vITK1;
    }

    public void setVITK1(VITK1_ vITK1) {
        this.vITK1 = vITK1;
    }

}
