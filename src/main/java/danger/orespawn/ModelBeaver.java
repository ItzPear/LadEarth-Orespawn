/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ public class ModelBeaver
/*     */   extends ModelBase {
/*  10 */   private float wingspeed = 1.0F;
/*     */   
/*     */   ModelRenderer head;
/*     */   
/*     */   ModelRenderer nose;
/*     */   
/*     */   ModelRenderer teeth;
/*     */   ModelRenderer body;
/*     */   ModelRenderer tail;
/*     */   ModelRenderer rff;
/*     */   ModelRenderer lff;
/*     */   ModelRenderer rrf;
/*     */   ModelRenderer lrf;
/*     */   
/*     */   public ModelBeaver(float f1) {
/*  25 */     this.wingspeed = f1;
/*     */     
/*  27 */     this.textureWidth = 64;
/*  28 */     this.textureHeight = 32;
/*     */     
/*  30 */     this.head = new ModelRenderer(this, 0, 3);
/*  31 */     this.head.addBox(0.0F, 0.0F, 0.0F, 6, 5, 5);
/*  32 */     this.head.setRotationPoint(0.0F, 15.0F, -8.0F);
/*  33 */     this.head.setTextureSize(64, 32);
/*  34 */     this.head.mirror = true;
/*  35 */     setRotation(this.head, 0.0F, 0.0F, 0.0F);
/*  36 */     this.nose = new ModelRenderer(this, 6, 0);
/*  37 */     this.nose.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
/*  38 */     this.nose.setRotationPoint(2.0F, 18.0F, -8.5F);
/*  39 */     this.nose.setTextureSize(64, 32);
/*  40 */     this.nose.mirror = true;
/*  41 */     setRotation(this.nose, 0.0F, 0.0F, 0.0F);
/*  42 */     this.teeth = new ModelRenderer(this, 0, 0);
/*  43 */     this.teeth.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
/*  44 */     this.teeth.setRotationPoint(2.0F, 19.0F, -8.2F);
/*  45 */     this.teeth.setTextureSize(64, 32);
/*  46 */     this.teeth.mirror = true;
/*  47 */     setRotation(this.teeth, 0.0F, 0.0F, 0.0F);
/*  48 */     this.body = new ModelRenderer(this, 0, 13);
/*  49 */     this.body.addBox(0.0F, 0.0F, 0.0F, 8, 8, 10);
/*  50 */     this.body.setRotationPoint(-1.0F, 14.0F, -3.0F);
/*  51 */     this.body.setTextureSize(64, 32);
/*  52 */     this.body.mirror = true;
/*  53 */     setRotation(this.body, 0.0F, 0.0F, 0.0F);
/*  54 */     this.tail = new ModelRenderer(this, 22, 0);
/*  55 */     this.tail.addBox(0.0F, -1.0F, 0.0F, 5, 1, 8);
/*  56 */     this.tail.setRotationPoint(0.5F, 21.0F, 7.0F);
/*  57 */     this.tail.setTextureSize(64, 32);
/*  58 */     this.tail.mirror = true;
/*  59 */     setRotation(this.tail, 0.0F, 0.0F, 0.0F);
/*  60 */     this.rff = new ModelRenderer(this, 22, 9);
/*  61 */     this.rff.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
/*  62 */     this.rff.setRotationPoint(-0.5F, 22.0F, -2.5F);
/*  63 */     this.rff.setTextureSize(64, 32);
/*  64 */     this.rff.mirror = true;
/*  65 */     setRotation(this.rff, 0.0F, 0.0F, 0.0F);
/*  66 */     this.lff = new ModelRenderer(this, 22, 9);
/*  67 */     this.lff.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
/*  68 */     this.lff.setRotationPoint(4.5F, 22.0F, -2.5F);
/*  69 */     this.lff.setTextureSize(64, 32);
/*  70 */     this.lff.mirror = true;
/*  71 */     setRotation(this.lff, 0.0F, 0.0F, 0.0F);
/*  72 */     this.rrf = new ModelRenderer(this, 22, 9);
/*  73 */     this.rrf.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
/*  74 */     this.rrf.setRotationPoint(-0.5F, 22.0F, 4.5F);
/*  75 */     this.rrf.setTextureSize(64, 32);
/*  76 */     this.rrf.mirror = true;
/*  77 */     setRotation(this.rrf, 0.0F, 0.0F, 0.0F);
/*  78 */     this.lrf = new ModelRenderer(this, 22, 9);
/*  79 */     this.lrf.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
/*  80 */     this.lrf.setRotationPoint(4.5F, 22.0F, 4.5F);
/*  81 */     this.lrf.setTextureSize(64, 32);
/*  82 */     this.lrf.mirror = true;
/*  83 */     setRotation(this.lrf, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  88 */     float newangle = 0.0F;
/*  89 */     super.render(entity, f, f1, f2, f3, f4, f5);
/*  90 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */ 
/*     */     
/*  93 */     newangle = MathHelper.cos(f2 * 3.7F * this.wingspeed) * 3.1415927F * 0.45F * f1;
/*  94 */     this.lrf.rotateAngleX = newangle;
/*  95 */     this.rrf.rotateAngleX = -newangle;
/*     */     
/*  97 */     newangle = MathHelper.cos(f2 * 2.7F * this.wingspeed) * 3.1415927F * 0.25F;
/*  98 */     this.teeth.rotateAngleX = newangle;
/*     */     
/* 100 */     newangle = MathHelper.cos(f2 * 0.5F * this.wingspeed) * 3.1415927F * 0.05F;
/* 101 */     this.tail.rotateAngleX = newangle;
/*     */     
/* 103 */     this.head.render(f5);
/* 104 */     this.nose.render(f5);
/* 105 */     this.teeth.render(f5);
/* 106 */     this.body.render(f5);
/* 107 */     this.tail.render(f5);
/* 108 */     this.rff.render(f5);
/* 109 */     this.lff.render(f5);
/* 110 */     this.rrf.render(f5);
/* 111 */     this.lrf.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 117 */     model.rotateAngleX = x;
/* 118 */     model.rotateAngleY = y;
/* 119 */     model.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
/* 124 */     super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelBeaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */